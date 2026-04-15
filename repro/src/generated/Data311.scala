package generated

final case class Data311(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data311 = copy(name = name.toUpperCase)
  def scale(k: Double): Data311 = copy(value = value * k)
  def addTag(t: String): Data311 = copy(tags = t :: tags)
  def put(k: String, v: String): Data311 = copy(meta = meta.updated(k, v))
  def merge(other: Data311): Data311 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data311 {
  given Ordering[Data311] = Ordering.by(_.id)
  def empty: Data311 = Data311(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data311 =
    Data311(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data311] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

package generated

final case class Data65(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data65 = copy(name = name.toUpperCase)
  def scale(k: Double): Data65 = copy(value = value * k)
  def addTag(t: String): Data65 = copy(tags = t :: tags)
  def put(k: String, v: String): Data65 = copy(meta = meta.updated(k, v))
  def merge(other: Data65): Data65 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data65 {
  given Ordering[Data65] = Ordering.by(_.id)
  def empty: Data65 = Data65(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data65 =
    Data65(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data65] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

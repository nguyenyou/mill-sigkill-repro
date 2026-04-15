package generated

final case class Data1311(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1311 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1311 = copy(value = value * k)
  def addTag(t: String): Data1311 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1311 = copy(meta = meta.updated(k, v))
  def merge(other: Data1311): Data1311 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1311 {
  given Ordering[Data1311] = Ordering.by(_.id)
  def empty: Data1311 = Data1311(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1311 =
    Data1311(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1311] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

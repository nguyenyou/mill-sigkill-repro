package generated

final case class Data867(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data867 = copy(name = name.toUpperCase)
  def scale(k: Double): Data867 = copy(value = value * k)
  def addTag(t: String): Data867 = copy(tags = t :: tags)
  def put(k: String, v: String): Data867 = copy(meta = meta.updated(k, v))
  def merge(other: Data867): Data867 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data867 {
  given Ordering[Data867] = Ordering.by(_.id)
  def empty: Data867 = Data867(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data867 =
    Data867(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data867] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

package generated

final case class Data225(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data225 = copy(name = name.toUpperCase)
  def scale(k: Double): Data225 = copy(value = value * k)
  def addTag(t: String): Data225 = copy(tags = t :: tags)
  def put(k: String, v: String): Data225 = copy(meta = meta.updated(k, v))
  def merge(other: Data225): Data225 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data225 {
  given Ordering[Data225] = Ordering.by(_.id)
  def empty: Data225 = Data225(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data225 =
    Data225(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data225] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

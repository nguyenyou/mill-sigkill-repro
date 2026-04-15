package generated

final case class Data602(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data602 = copy(name = name.toUpperCase)
  def scale(k: Double): Data602 = copy(value = value * k)
  def addTag(t: String): Data602 = copy(tags = t :: tags)
  def put(k: String, v: String): Data602 = copy(meta = meta.updated(k, v))
  def merge(other: Data602): Data602 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data602 {
  given Ordering[Data602] = Ordering.by(_.id)
  def empty: Data602 = Data602(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data602 =
    Data602(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data602] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

package generated

final case class Data634(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data634 = copy(name = name.toUpperCase)
  def scale(k: Double): Data634 = copy(value = value * k)
  def addTag(t: String): Data634 = copy(tags = t :: tags)
  def put(k: String, v: String): Data634 = copy(meta = meta.updated(k, v))
  def merge(other: Data634): Data634 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data634 {
  given Ordering[Data634] = Ordering.by(_.id)
  def empty: Data634 = Data634(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data634 =
    Data634(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data634] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

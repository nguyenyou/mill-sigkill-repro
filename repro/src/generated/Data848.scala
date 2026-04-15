package generated

final case class Data848(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data848 = copy(name = name.toUpperCase)
  def scale(k: Double): Data848 = copy(value = value * k)
  def addTag(t: String): Data848 = copy(tags = t :: tags)
  def put(k: String, v: String): Data848 = copy(meta = meta.updated(k, v))
  def merge(other: Data848): Data848 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data848 {
  given Ordering[Data848] = Ordering.by(_.id)
  def empty: Data848 = Data848(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data848 =
    Data848(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data848] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

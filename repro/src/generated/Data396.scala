package generated

final case class Data396(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data396 = copy(name = name.toUpperCase)
  def scale(k: Double): Data396 = copy(value = value * k)
  def addTag(t: String): Data396 = copy(tags = t :: tags)
  def put(k: String, v: String): Data396 = copy(meta = meta.updated(k, v))
  def merge(other: Data396): Data396 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data396 {
  given Ordering[Data396] = Ordering.by(_.id)
  def empty: Data396 = Data396(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data396 =
    Data396(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data396] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

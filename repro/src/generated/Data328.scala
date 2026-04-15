package generated

final case class Data328(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data328 = copy(name = name.toUpperCase)
  def scale(k: Double): Data328 = copy(value = value * k)
  def addTag(t: String): Data328 = copy(tags = t :: tags)
  def put(k: String, v: String): Data328 = copy(meta = meta.updated(k, v))
  def merge(other: Data328): Data328 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data328 {
  given Ordering[Data328] = Ordering.by(_.id)
  def empty: Data328 = Data328(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data328 =
    Data328(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data328] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

package generated

final case class Data144(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data144 = copy(name = name.toUpperCase)
  def scale(k: Double): Data144 = copy(value = value * k)
  def addTag(t: String): Data144 = copy(tags = t :: tags)
  def put(k: String, v: String): Data144 = copy(meta = meta.updated(k, v))
  def merge(other: Data144): Data144 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data144 {
  given Ordering[Data144] = Ordering.by(_.id)
  def empty: Data144 = Data144(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data144 =
    Data144(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data144] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

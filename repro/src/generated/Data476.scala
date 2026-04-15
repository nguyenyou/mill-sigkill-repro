package generated

final case class Data476(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data476 = copy(name = name.toUpperCase)
  def scale(k: Double): Data476 = copy(value = value * k)
  def addTag(t: String): Data476 = copy(tags = t :: tags)
  def put(k: String, v: String): Data476 = copy(meta = meta.updated(k, v))
  def merge(other: Data476): Data476 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data476 {
  given Ordering[Data476] = Ordering.by(_.id)
  def empty: Data476 = Data476(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data476 =
    Data476(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data476] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

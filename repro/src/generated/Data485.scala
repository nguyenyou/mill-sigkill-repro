package generated

final case class Data485(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data485 = copy(name = name.toUpperCase)
  def scale(k: Double): Data485 = copy(value = value * k)
  def addTag(t: String): Data485 = copy(tags = t :: tags)
  def put(k: String, v: String): Data485 = copy(meta = meta.updated(k, v))
  def merge(other: Data485): Data485 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data485 {
  given Ordering[Data485] = Ordering.by(_.id)
  def empty: Data485 = Data485(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data485 =
    Data485(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data485] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

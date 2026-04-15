package generated

final case class Data1101(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1101 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1101 = copy(value = value * k)
  def addTag(t: String): Data1101 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1101 = copy(meta = meta.updated(k, v))
  def merge(other: Data1101): Data1101 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1101 {
  given Ordering[Data1101] = Ordering.by(_.id)
  def empty: Data1101 = Data1101(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1101 =
    Data1101(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1101] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

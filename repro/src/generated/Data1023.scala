package generated

final case class Data1023(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1023 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1023 = copy(value = value * k)
  def addTag(t: String): Data1023 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1023 = copy(meta = meta.updated(k, v))
  def merge(other: Data1023): Data1023 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1023 {
  given Ordering[Data1023] = Ordering.by(_.id)
  def empty: Data1023 = Data1023(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1023 =
    Data1023(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1023] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

package generated

final case class Data1202(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1202 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1202 = copy(value = value * k)
  def addTag(t: String): Data1202 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1202 = copy(meta = meta.updated(k, v))
  def merge(other: Data1202): Data1202 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1202 {
  given Ordering[Data1202] = Ordering.by(_.id)
  def empty: Data1202 = Data1202(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1202 =
    Data1202(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1202] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

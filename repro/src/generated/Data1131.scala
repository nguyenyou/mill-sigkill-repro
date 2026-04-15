package generated

final case class Data1131(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1131 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1131 = copy(value = value * k)
  def addTag(t: String): Data1131 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1131 = copy(meta = meta.updated(k, v))
  def merge(other: Data1131): Data1131 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1131 {
  given Ordering[Data1131] = Ordering.by(_.id)
  def empty: Data1131 = Data1131(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1131 =
    Data1131(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1131] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

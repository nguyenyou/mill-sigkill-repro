package generated

final case class Data1151(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1151 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1151 = copy(value = value * k)
  def addTag(t: String): Data1151 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1151 = copy(meta = meta.updated(k, v))
  def merge(other: Data1151): Data1151 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1151 {
  given Ordering[Data1151] = Ordering.by(_.id)
  def empty: Data1151 = Data1151(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1151 =
    Data1151(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1151] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

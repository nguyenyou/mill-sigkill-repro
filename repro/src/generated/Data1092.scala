package generated

final case class Data1092(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1092 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1092 = copy(value = value * k)
  def addTag(t: String): Data1092 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1092 = copy(meta = meta.updated(k, v))
  def merge(other: Data1092): Data1092 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1092 {
  given Ordering[Data1092] = Ordering.by(_.id)
  def empty: Data1092 = Data1092(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1092 =
    Data1092(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1092] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

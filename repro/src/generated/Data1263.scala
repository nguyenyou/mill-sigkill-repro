package generated

final case class Data1263(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1263 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1263 = copy(value = value * k)
  def addTag(t: String): Data1263 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1263 = copy(meta = meta.updated(k, v))
  def merge(other: Data1263): Data1263 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1263 {
  given Ordering[Data1263] = Ordering.by(_.id)
  def empty: Data1263 = Data1263(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1263 =
    Data1263(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1263] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

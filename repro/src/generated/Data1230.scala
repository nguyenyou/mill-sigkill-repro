package generated

final case class Data1230(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1230 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1230 = copy(value = value * k)
  def addTag(t: String): Data1230 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1230 = copy(meta = meta.updated(k, v))
  def merge(other: Data1230): Data1230 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1230 {
  given Ordering[Data1230] = Ordering.by(_.id)
  def empty: Data1230 = Data1230(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1230 =
    Data1230(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1230] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}

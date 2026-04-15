package generated

final case class Data1264(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1264 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1264 = copy(value = value * k)
  def addTag(t: String): Data1264 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1264 = copy(meta = meta.updated(k, v))
  def merge(other: Data1264): Data1264 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1264 {
  given Ordering[Data1264] = Ordering.by(_.id)
  def empty: Data1264 = Data1264(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1264 =
    Data1264(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1264] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
